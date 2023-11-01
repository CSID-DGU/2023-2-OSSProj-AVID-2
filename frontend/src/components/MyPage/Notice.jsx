import React from 'react';
import styled from 'styled-components';
const NoticeContainer = styled.div`
    content: "";
    margin-top: 70px;
`;

const Board = () => {
    return (
        <NoticeContainer>
            <h1>Board Screen</h1>
            {/* Add your board content here */}
        </NoticeContainer>
    );
};

export default Board;
