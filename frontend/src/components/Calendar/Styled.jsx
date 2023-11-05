import styled from 'styled-components';
import Modal from 'react-modal';

//Calendar.jsx
export const CalendarContainer = styled.div`
    padding: 20px;
    margin-top: 40px;
    margin-left: 80px;
    width: 80%;
    height: 80%;
    position: relative;
    
`;


//AddBtn.jsx
export const AddBtnContainer = styled.div`
    width: 100%;
    height: 600px;
    position: relative;
    background: white;
`;

export const ModalTitleLabel = styled.div`
    width: 200px;
    font-size: 60px;
    font-family: 'DM Sans';
    font-weight: 500;
    color: rgba(0, 0, 0, 0.50);
    word-wrap: break-word;
    
`;

export const ModalContentLabel = styled.div`
    width: 200px;
    height: 55px;
    margin-left: 40px;
    font-size: 40px;
    font-family: 'DM Sans';
    font-weight: 500;
    color: rgba(0, 0, 0, 0.50);
    word-wrap: break-word;
    
`;

export const AddButton = styled.button`
    background-color: #4339F2;
    color: white;
    border: none;
    border-radius: 50%;
    font-size: 1rem;
    width: 50px;
    height: 50px;
    cursor: pointer;
    position: absolute;
    left: 83%;
    transition: all 0.2s ease-in-out;
    margin-top: 40px;
    &:hover {
        background-color: #807dbe;
        transform: scale(1.1);
    }

    &:active {
        background-color: #4339F2;
        transform: scale(0.9);
    }
    z-index: 10;
`;

export const AddBtnModal = styled(Modal)`
    .AddBtn-modal {
        background-color: gray;
        border-radius: 10px;
        padding: 20px;
        position: relative;
        z-index: 10;
    }
`;

export const CheckButton = styled.button`
        margin-top: 20px;
        background-color: #4339F2;
        color: white;
        border: none;
        font-size: 1rem;
        width: 100px;
        height: 50px;
        cursor: pointer;
        position: relative;
        left: 42.5%;
`;
export const CancelButton = styled.button`
        margin-top: 20px;
        background-color: #4339F2;
        margin-left: 20px;
        color: white;
        border: none;
        font-size: 1rem;
        width: 100px;
        height: 50px;
        cursor: pointer;
        position: relative;
        left: 42.5%;
`;

export const FlexContainer = styled.div`
        display: flex;
        align-items: center;
        margin-left: 40px;
`;