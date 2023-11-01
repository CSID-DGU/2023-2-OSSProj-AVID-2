import React from 'react';
import Calendar from './Calendar';
import Notice from './Notice';
import styled from 'styled-components';
import AddBtn from './AddBtn';

const Container = styled.div`
    position: relative;
    flex: 1;
`;

const Wrapper = () => {
    return (
        <Container>
            <AddBtn />
            <Calendar />
            <Notice />
        </Container>
    );
};

export default Wrapper;
