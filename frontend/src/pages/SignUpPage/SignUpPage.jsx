import React, { useState } from 'react';

const SignUpPage = () => {
    const [studentId, setStudentId] = useState('');
    const [password, setPassword] = useState('');
    const [passwordCheck, setPasswordCheck] = useState('');

    const handleSignup = (e) => {
        e.preventDefault();
        if (password !== passwordCheck) {
            alert('Passwords do not match');
            return;
        }
        // handle signup logic here
    };

    return (
        <div>
            <h1>Sign Up</h1>
            <form onSubmit={handleSignup}>
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
