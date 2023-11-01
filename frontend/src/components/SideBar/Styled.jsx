import styled from 'styled-components';

export const SideBarContainer = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: #f5f5f5;
    padding: 20px;
    width: 100px;
    height: 100%;
`;

export const MenuList = styled.ul`
    list-style: none;
    margin: 0;
    padding: 0;
    width: 100%;
`;

export const MenuItem = styled.li`
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