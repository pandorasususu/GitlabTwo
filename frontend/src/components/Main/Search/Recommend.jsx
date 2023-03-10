import { useNavigate } from 'react-router-dom';
import { useMainState } from '../MainContext';
import CustomButton from 'components/common/CustomButton';

function Recommend({ children }) {
  const { location, range } = useMainState();
  const navigate = useNavigate();

  const handleClick = () => {
    localStorage.setItem('current', JSON.stringify(location));
    localStorage.setItem('range', range);
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
