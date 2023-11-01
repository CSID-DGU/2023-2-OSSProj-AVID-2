import React, { useState } from 'react';
import API from '../../api/axios.jsx';
import { Navigate } from 'react-router-dom';

const SignUpPage = () => {
    const [studentId, setStudentId] = useState('');
    const [password, setPassword] = useState('');
    const [passwordCheck, setPasswordCheck] = useState('');

    async function SignUp(e) {
        e.preventDefault(); // 기본 동작 중지
        try {
            // POST 요청 코드
            const response = await API.post('/signup', {
                userID: studentId,
                userPwd: password,
                userName: "test",
                userType: "STUDENT"
            });
            console.log(response);
        } catch (error) {
            console.log("error");
            console.error(error);
        }
    }

    return (
        <div>
            <h1>Sign Up</h1>
            <form onSubmit={SignUp}>
                <label htmlFor="studentId">학번:</label>
                <input
                    type="text"
                    id="studentId"
                    value={studentId}
                    onChange={(e) => setStudentId(e.target.value)}
                />
                <br />
                <label htmlFor="password">비밀번호:</label>
                <input
                    type="password"
                    id="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <br />
                <label htmlFor="passwordCheck">비밀번호 확인:</label>
                <input
                    type="password"
                    id="passwordCheck"
                    value={passwordCheck}
                    onChange={(e) => setPasswordCheck(e.target.value)}
                />
                <br />
                <button type="submit">Sign Up</button>
            </form>
        </div>
    );
};

export default SignUpPage;
