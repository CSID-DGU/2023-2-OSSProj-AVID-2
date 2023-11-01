import React from 'react';
import styled from 'styled-components';

import MyPageContent from '../../components/MyPage/MyPageContent';
import SideBar from '../../components/SideBar/SideBar';

const Container = styled.div`
    width: 100vw;
    height: 100vh;
    display: flex;
    position: relative;
`

const MyPage = () => {
    return (
        <Container>
            
            <SideBar />
            <MyPageContent />

        </Container>
    );
};

export default MyPage;
