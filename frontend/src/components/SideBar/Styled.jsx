import styled from "styled-components";

export const SideBarContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #f5f5f5;
  padding: 20px;
  width: 160px;
  height: 100%;
`;

export const MenuList = styled.ul`
  list-style: none;
  margin: 0;
  padding: 0;
  width: 100%;
`;

export const MenuItem = styled.li`
  padding: 1px;
  font-size: 16px;
  font-weight: bold;
  text-align: left;
  color: #333;
  cursor: pointer;
  transition: background-color 0.3s ease;

  &:hover {
    background-color: #ddd;
  }
`;

export const SidebarLogo = styled.img`
  top: 0;
  width: 200px;
  height: 80px;
`;

export const ListLine = styled.div`
  width: 170px;
  height: 3px;
  border-radius: 5px;
  background-color: #bd9b9b;
`;
