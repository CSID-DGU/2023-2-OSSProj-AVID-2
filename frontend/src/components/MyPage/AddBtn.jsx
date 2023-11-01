import React, { useState } from "react";
import Modal from "react-modal";
import styled from "styled-components";

const Container = styled.div`
    width: 100%;
    height: 600px;
    position: relative;
    background: white;
`;

const Label = styled.div`
    width: 200px;
    font-size: 60px;
    font-family: 'DM Sans';
    font-weight: 500;
    color: rgba(0, 0, 0, 0.50);
    word-wrap: break-word;
    
`;

const Label40 = styled.div`
    width: 200px;
    height: 55px;
    margin-left: 40px;
    font-size: 40px;
    font-family: 'DM Sans';
    font-weight: 500;
    color: rgba(0, 0, 0, 0.50);
    word-wrap: break-word;
    
`;

const AddButton = styled.button`
    background-color: #4339F2;
    color: white;
    border: none;
    border-radius: 50%;
    font-size: 1rem;
    width: 50px;
    height: 50px;
    cursor: pointer;
    position: absolute;
    left: 83%;
    transition: all 0.2s ease-in-out;

    &:hover {
        background-color: #4339F2;
        transform: scale(1.1);
    }

    &:active {
        background-color: #4339F2;
        transform: scale(0.9);
    }
`;

const AddBtnModal = styled(Modal)`
    .AddBtn-modal {
        background-color: gray;
        border-radius: 10px;
        padding: 20px;
        position: relative;
        z-index: 10;
    }
`;

const customStyles = {
    content: {

        backgroundColor: "gray",
        border: "none",
        borderRadius: "10px",
        padding: "20px",
    },
    overlay: {
        backgroundColor: "rgba(0, 0, 0, 0.5)",
        zIndex: 1000,
    },
 };

const Input = styled.input`
        background: transparent; // 배경을 투명하게 설정
        border: none;
        width: 100%;
        padding: 0.2rem;
        font-size: ${({ isTitle }) => (isTitle ? '80px' : '40px')};
        margin-top: 20px;
        margin-right: 20px;
    `;

const CheckButton = styled.button`
        margin-top: 20px;
        background-color: #4339F2;
        color: white;
        border: none;
        font-size: 1rem;
        width: 100px;
        height: 50px;
        cursor: pointer;
        position: relative;
        left: 42.5%;
`;
const CancelButton = styled.button`
        margin-top: 20px;
        background-color: #4339F2;
        margin-left: 20px;
        color: white;
        border: none;
        font-size: 1rem;
        width: 100px;
        height: 50px;
        cursor: pointer;
        position: relative;
        left: 42.5%;
`;

const FlexContainer = styled.div`
        display: flex;
        align-items: center;
        margin-left: 40px;
`;

const AddBtn = () => {
    const [modalIsOpen, setModalIsOpen] = useState(false);
    const [title, setTitle] = useState("");
    const [tags, setTags] = useState("");
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");

    const handleAddEvent = () => {
        // handle adding event to calendar
        console.log("Title:", title);
        console.log("Tags:", tags);
        console.log("Start Date:", startDate);
        console.log("End Date:", endDate);
        setModalIsOpen(false);
    };

    return (
        <>
            <AddButton onClick={() => setModalIsOpen(true)}>+</AddButton>
            <AddBtnModal
                isOpen={modalIsOpen}
                onRequestClose={() => setModalIsOpen(false)}
                style={customStyles}
            >
                <Container>
                    
                    <form onSubmit={handleAddEvent}>
                        <FlexContainer>
                            <Label>제목:</Label>
                            <Input
                                type="text"
                                value={title}
                                onChange={(e) => setTitle(e.target.value)}
                                isTitle={true}
                            />
                        </FlexContainer>
                        <br />
                        <FlexContainer>
                            <Label40> 태그:</Label40>
                            <Input
                                type="text"
                                value={tags}
                                onChange={(e) => setTags(e.target.value)}
                                isTitle={false}
                            />
                        </FlexContainer>
                        <br />
                        <FlexContainer>
                            <Label40>시작일:</Label40>
                            <Input
                                type="text"
                                value={startDate}
                                onChange={(e) => setStartDate(e.target.value)}
                                isTitle={false}
                            />
                        </FlexContainer>
                        <br />
                        <FlexContainer>
                            <Label40>마감일:</Label40>
                            <Input
                                type="text"
                                value={endDate}
                                onChange={(e) => setEndDate(e.target.value)}
                                isTitle={false}
                            />
                        </FlexContainer>
                        <br />
                        <CheckButton type="submit">Add</CheckButton>
                        <CancelButton onClick={() => setModalIsOpen(false)}>Cancel</CancelButton>
                    </form>
                </Container>
            </AddBtnModal>
        </>
    );
};

export default AddBtn;
