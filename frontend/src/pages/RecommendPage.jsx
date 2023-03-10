import 'styles/Recommend/RecommendPage.scss';
import { useEffect, useState } from 'react';
import { useRecommendContext } from 'components/Recommend/Context/RecommendContext';
import Container from 'components/common/Container';
import CloseRecommend from 'components/Recommend/CloseRecommend';
import PrevNext from 'components/Recommend/PrevNext';
import Music from 'components/Recommend/Music';
import Title from 'components/Recommend/Title';
import Food from 'components/Recommend/Food';
import Activity from 'components/Recommend/Activity';
import {
  setCurrentMusic,
  setMusicList,
} from 'components/Recommend/Context/musicReducer';
import {
  setCurrentFood,
  setFoodList,
} from 'components/Recommend/Context/foodReducer';
import {
  setActivityList,
  setCurrentActivity,
} from 'components/Recommend/Context/activityReducer';
import {
  getActivityRecommend,
  getFoodRecommend,
  getMusicRecommend,
} from 'api/recommend';
import Loading from 'components/Recommend/Loading';
import { getMusicUris } from 'api/spotify';

const titles = [
  ['가장 듣고 싶은 음악을', '1개 골라주세요!'],
  ['어떤 음식을', '먹고 싶으신가요?'],
  ['어떤 활동을', '하고 싶으신가요?'],
];

function RecommendPage() {
  const { state, dispatch } = useRecommendContext();
  const index = state.indexReducer.index;
  const [music, setMusic] = useState(false);
  const [food, setFood] = useState(false);
  const [activity, setActivity] = useState(false);

  const payload = {
    location: JSON.parse(localStorage.getItem('current')),
    distance: localStorage.getItem('range'),
  };

  // music
  useEffect(() => {
    getMusicRecommend(
      0,
      async (res) => {
        const uris = await getMusicUris(res.data);
        dispatch(setMusicList(uris));
        dispatch(setCurrentMusic(uris[0]));
        setMusic(true);
      },
      (err) => console.log(err)
    );
  }, []);

  // food
  useEffect(() => {
    getFoodRecommend(
      0,
      payload,
      (res) => {
        dispatch(setFoodList(res.data));
        dispatch(setCurrentFood(res.data[0]));
        setFood(true);
      },
      (err) => console.log(err)
    );
  }, []);

  // activity
  useEffect(() => {
    getActivityRecommend(
      0,
      payload,
      (res) => {
        dispatch(setActivityList(res.data));
        dispatch(setCurrentActivity(res.data[0]));
        setActivity(true);
      },
      (err) => console.log(err)
    );
  }, []);

  return (
    <Container>
      {(!music || !food || !activity) && <Loading />}
      {music && food && activity && (
        <>
          <CloseRecommend />
          <div className="recommend-content">
            <Title title={titles[index]} />
            {index === 0 ? <Music /> : index === 1 ? <Food /> : <Activity />}
          </div>
          <PrevNext index={index} />
        </>
      )}
    </Container>
  );
}

export default RecommendPage;
