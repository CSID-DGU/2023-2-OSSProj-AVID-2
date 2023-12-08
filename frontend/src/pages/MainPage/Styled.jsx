import styled from 'styled-components';

export const Container = styled.div`
  width: 100vw;
  height: 100vw;
  background: url("img/main_bg.jpg") no-repeat;
  background-size: cover;
  background-position: center center;
  background-attachment: fixed;
  position: relative;
  overflow: hidden;
  display: flex;
  justify-content: center;
  
`;
export const NoticeContinaer = styled.div`
  background-color: #E15E39;
  padding: 20px;
  margin-top: 20px;
  width : 25vw;
  height : 15vw;
  display: flex;
  flex-direction: column;
  align-items: left;
`;

export const LectureContainer = styled.div`
  background-color: #EB9332;
  padding: 20px;
  margin-top: 20px;
  width : 25vw;
  height : 15vw;
  display: flex;
  flex-direction: column;
  align-items: left;
  text-align: left;
`;

export const DueLectureContainer = styled.div`
  background-color: #EDC219;
  padding: 20px;
  margin-top: 20px;
  width : 25vw;
  height : 15vw;
  display: flex;
  flex-direction: column;
  align-items: left;
  
`;

export const TitleBox = styled.div`
  background-color: none;
  
  border-radius: 5px;
  margin-bottom: 10px;
  color : #FFFFFF;
  font-weight: bold;
  text-align: left;

`;

export const LectureList = styled.div`
  color: #6D4D00;
  font-size: 12px;
  vertical-align: middle;
`;

export const NoticeText = styled.div`
    color: #FFFFFF;
    font-size: 12px;
`;

export const NoticeList = styled.li`
    color: #FFFFFF;
    font-size: 12px;
    text-align: left;
    margin-top: 10px;

`;

export const ImageBox = styled.div`
    background: url("img/logo_line.png") no-repeat;
    background-size: cover;
    background-position: center center;
    
    position: relative;
    overflow: hidden;
    display: flex;
    justify-content: center;
    width : 30%;
    height : 50%;
    margin:auto;
    `;