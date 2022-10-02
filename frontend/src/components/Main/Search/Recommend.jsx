import { useNavigate } from 'react-router-dom';
import { useMainState } from '../MainContext';
import CustomButton from 'components/common/CustomButton';
import {
  getActivityRecommend,
  getFoodRecommend,
  getMusicRecommend,
} from 'api/recommend';

function Recommend({ children }) {
  const { location, range } = useMainState();
  const navigate = useNavigate();

  const handleClick = () => {
    localStorage.setItem('current', JSON.stringify(location));
    localStorage.setItem('range', range);

    const payload = { location, distance: range };

    getMusicRecommend(
      0,
      (res) => console.log(res),
      (err) => console.log(err)
    );
    getFoodRecommend(
      0,
      payload,
      (res) => console.log(res),
      (err) => console.log(err)
    );
    getActivityRecommend(
      0,
      payload,
      (res) => console.log(res),
      (err) => console.log(err)
    );

    navigate(`/recommend`);
  };

  return (
    <CustomButton
      className="search__button"
      variant="contained"
      size="large"
      sx={{ marginTop: '15px' }}
      onClick={handleClick}
    >
      {children}
    </CustomButton>
  );
}

export default Recommend;
