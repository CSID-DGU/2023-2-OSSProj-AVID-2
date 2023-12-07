import React, { useState, useEffect } from 'react';
import API from '../../api/axios';
import { Navigate } from 'react-router-dom';

function LecturePage() {
  const [lectureList, setLectureList] = useState([]);
  const [selectedLectures, setSelectedLectures] = useState([]);

  useEffect(() => {
    getLectureList();
  }, []);

  const getLectureList = async () => {
    try {
      const response = await API.get("/api/subjects");
      setLectureList(response.data);
    } catch (error) {
      console.error(error);
    }
  }

  const handleLectureClick = (lecture) => {
    setSelectedLectures((prevSelectedLectures) => {
      if (prevSelectedLectures.includes(lecture)) {
        return prevSelectedLectures.filter((selectedLecture) => selectedLecture !== lecture);
      } else {
        return [...prevSelectedLectures, lecture];
      }
    });
  }

  const handlePostSelectedLectures = async () => {
    try {
      // 선택한 강의의 id 목록을 추출
      const selectedIds = selectedLectures.map(lecture => lecture.id);
  
      // 서버로 보낼 데이터 형식을 정의
      const requestData = {
        id: selectedIds
      };
  
      // POST 요청 보내기
      const response = await API.post("/subjects", requestData);
  
      // 성공 시 처리
      console.log("강의 등록 성공", response.data);
      Navigate("/mypage")
      
    } catch (error) {
      // 실패 시 처리
      console.error("강의 등록 실패", error);
    }
  };



  return (
    <div>
      <h1>수강 과목 선택</h1>
      <ul>
        {lectureList.map((lecture) => (
          <li key={lecture.id} onClick={() => handleLectureClick(lecture)}>
            <button 
              style={{ background: selectedLectures.includes(lecture) ? 'lightblue' : 'gray' }}
            >
              {lecture.subjectName} - {lecture.professor}
            </button>
          </li>
        ))}
      </ul>
      <button onClick={handlePostSelectedLectures}>제출</button>
    </div>
  );
}

export default LecturePage;
