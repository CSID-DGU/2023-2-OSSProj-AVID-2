import Nav from "./Nav"
import { Outlet } from "react-router-dom"
import { styled } from "styled-components" 

export const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
    margin: 0;
    
`
export const OutletContainer = styled.div`
    flex: 1; /* Outlet이 부모 컨테이너를 채우도록 설정 */
    margin-top: 30px; /* Nav 바 아래 간격 설정 */
`

export const Layout = () => {   
    return (
        <Container> 
            <Nav/> 
            <OutletContainer>
                <Outlet/>
            </OutletContainer>
            
        </Container>
    )
}

