import React from 'react';
import styled from 'styled-components';

export const Container = styled.div`
  width: 100vw;
  height: 100vh;
  background: url('img/main_bg.jpg') no-repeat;
  background-size: cover;
  background-position: center center;
  background-attachment: fixed;
  
  position: relative;
  overflow: hidden;
`;
  

export default function MainPage() {
    return (
      <Container>
        
      </Container>
    )
  }