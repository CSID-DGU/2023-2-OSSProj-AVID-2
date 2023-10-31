import React from 'react';
import styled from 'styled-components';

const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: #f5f5f5;
    padding: 20px;
    width: 100px;
    height: 100%;
`;


const MenuList = styled.ul`
    list-style: none;
    margin: 0;
    padding: 0;
    width: 100%;
`;

const MenuItem = styled.li`
    padding: 10px;
    font-size: 16px;
    font-weight: bold;
    color: #333;
    cursor: pointer;
    transition: background-color 0.3s ease;

    &:hover {
        background-color: #ddd;
    }
`;

const SideBar = () => {
        return (
                <Container>
                        <h4>사이버캠퍼스</h4> 
                        
                </Container>
        );
};

export default SideBar;
