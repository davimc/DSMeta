import './styles.css'
import icon from '../../assets/img/notification-icon.svg'
import axios from 'axios';
import { BASE_URL } from '../../utils/request';
import { toast } from 'react-toastify';

type Props = {
  saleId: number;
}
function handlerButton(id: number) {
  axios.get(`${BASE_URL}/sales/${id}/notification`)
    .then(response => {toast.info("SUCESSO")})
}
function NotificationButton({saleId}: Props) {
  
    return (
      <div className='dsmeta-red-btn' onClick={() => handlerButton(saleId)}>
        <img src={icon} alt="Notificar"/>
      </div>
    )
  }
  
  export default NotificationButton