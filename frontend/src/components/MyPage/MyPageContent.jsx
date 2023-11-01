import React from 'react';
import Calendar from '../Calendar/Calendar';
import Notice from './Notice';
import styled from 'styled-components';
import AddBtn from '../Calendar/AddTodo';

const WrapperContainer = styled.div`
    position: relative;
    flex: 1;
`;

const MyPage = () => {
    return (
        <WrapperContainer>
            <AddBtn />
            <Calendar />
            <Notice />
        </WrapperContainer>
    );
};

export default MyPage;
