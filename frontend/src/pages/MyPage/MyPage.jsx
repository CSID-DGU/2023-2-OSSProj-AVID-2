import React from 'react';
import styled from 'styled-components';

import Wrapper from '../../components/MyPage/Wrapper';
import SideBar from '../../components/MyPage/SideBar';

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
            <Wrapper />

        </Container>
    );
};

export default MyPage;
