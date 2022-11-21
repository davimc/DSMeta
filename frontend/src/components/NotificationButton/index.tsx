import './styles.css'
import icon from '../../assets/img/notification-icon.svg'
import axios from 'axios';
import { BASE_URL } from '../../utils/request';

type Props = {
  saleId: number;
}
function handlerButton(id: number) {
  axios.get(`${BASE_URL}/sales/${id}/notification`)
    .then(response => {console.log("SUCESSO")})
}
function NotificationButton({saleId}: Props) {
  
    return (
      <div className='dsmeta-red-btn' onClick={() => handlerButton(saleId)}>
        <img src={icon} alt="Notificar"/>
      </div>
    )
  }
  
  export default NotificationButton