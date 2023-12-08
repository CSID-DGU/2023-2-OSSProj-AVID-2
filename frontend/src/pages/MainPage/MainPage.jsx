import React, { useEffect, useState } from "react";
import * as s from "./Styled.jsx";
import API from "../../api/axios.jsx";


export default function MainPage() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [userInfo, setUserInfo] = useState({});
  const [lectureList, setLectureList] = useState([]);
  
  const getLectureList = async () => {
    try {
      const response = await API.get("/api/user-subjects");
      if(response.data.resultCode === "SUCCESS"){
        setLectureList(response.data.result);
      }
    } catch (error) {
      console.error(error);
    }
  }

  useEffect(() => {
    const checkLoginStatus = async () => {
      try {
        const response = await API.get("/home");

        if (response.data.resultCode === "SUCCESS") {
          setIsLoggedIn(true);
          setUserInfo(response.data.result);
        } else {
          setIsLoggedIn(false);
        }
      } catch (error) {
        console.error("Error checking login status:", error);
      }
    };

    checkLoginStatus();
    getLectureList();
  }, []);

  return (
    <s.Container>
      <s.NoticeContinaer>
        <s.TitleBox>공지사항</s.TitleBox>
        
          <s.NoticeList>eclass 인증서 로그인 매뉴얼</s.NoticeList>
          <s.NoticeList>e-class 재시험 매뉴얼</s.NoticeList>
          <s.NoticeList>e-Class 과제 및 시험 등록 매뉴얼</s.NoticeList>
          <s.NoticeList>[안내] 이클래스 사용을 위한 [Internet Explorer] 및 [Chrome] 설정 방법</s.NoticeList>
          <s.NoticeList>[안내] 학습자 업로드 자료실 관련</s.NoticeList>

      </s.NoticeContinaer>

      {isLoggedIn ? (
        <>
          {/* Content for logged-in user */}
          <s.LectureContainer>
            <s.TitleBox>내 강의실</s.TitleBox>
            <s.LectureList>
              {lectureList.map((lecture, index) => (
                <p key={index}>{lecture.subjectName}</p>
              ))}
            </s.LectureList>
          </s.LectureContainer>

          <s.DueLectureContainer>
            <s.TitleBox>의무 교육 강의실</s.TitleBox>
            {/* Render content for due lecture */}
          </s.DueLectureContainer>
        </>
      ) : (
        <>
          {/* Content for non-logged-in user */}
          <s.LectureContainer>
            <s.TitleBox>내 강의실</s.TitleBox>
            <s.ImageBox> </s.ImageBox>
            <s.NoticeText>로그인 후 사용 가능합니다.</s.NoticeText>
            {/* You can add an image or any content for non-logged-in state */}
          </s.LectureContainer>

          <s.DueLectureContainer>
            <s.TitleBox>의무 교육 강의실</s.TitleBox>
            <s.ImageBox> </s.ImageBox>
            <s.NoticeText>로그인 후 사용 가능합니다.</s.NoticeText>
            {/* You can add an image or any content for non-logged-in state */}
          </s.DueLectureContainer>
        </>
      )}
    </s.Container>
  );
}