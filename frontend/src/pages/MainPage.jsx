import { Button, Grid } from '@mui/material';
import styled from '@emotion/styled';
import BottomNav from 'components/common/BottomNav';
import Container from 'components/common/Container';
import Map from 'components/MainPage/Map';
import SearchLocation from 'components/MainPage/SearchLocation';
import SearchRange from 'components/MainPage/SearchRange';
import 'styles/MainPage/MainPage.scss';

const RecommendButton = styled(Button)`
  background-color: #92b4ec;
  border: none;
  box-shadow: 0px 2px 2px 0px rgb(0 0 0 / 14%);
  font-weight: 600;

  &.MuiButton-root:hover {
    background-color: #92b4ec;
  }
`;

function MainPage() {
  return (
    <Container>
      <Map />
      <div className="search">
        <Grid
          container
          className="search-inner"
          direction="column"
          justifyContent="center"
        >
          <SearchLocation />
          <SearchRange />
          <RecommendButton className="search__button" variant="contained" size="large" sx={{marginTop: "15px"}}>
            추천 시작
          </RecommendButton>
        </Grid>
      </div>
      <BottomNav />
    </Container>
  );
}

export default MainPage;