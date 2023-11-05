import React, { useState } from "react";
import styled from "styled-components";

import * as s from "./Styled.jsx"

import API from "../../api/axios.jsx";

const customModalStyles = {
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
        font-family: 'DM Sans';
        color: rgba(0, 0, 0, 0.50);
    `;


const AddBtn = () => {
    const [modalIsOpen, setModalIsOpen] = useState(false);
    const [title, setTitle] = useState("");
    const [tags, setTags] = useState("");
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");


    const handleAddEvent = async (e) => {
        e.preventDefault();

        const data = {
            title: title,
            content: tags,
            scheduleType: 'COMMON',
            startDate: '2023-11-04T17:17:36',
            endDate: '2023-11-06T17:17:36',
        };

        try {
            const response = await API.post('/schedule/personal', data);
            console.log(response.data);
        } catch (error) {
            console.error(error);
        }

        setModalIsOpen(false);
    };

    return (
        <>
            <s.AddButton onClick={() => setModalIsOpen(true)}>+</s.AddButton>
            <s.AddBtnModal
                isOpen={modalIsOpen}
                onRequestClose={() => setModalIsOpen(false)}
                style={customModalStyles}
            >
                <s.AddBtnContainer>
                    
                    <form onSubmit={handleAddEvent}>
                        <s.FlexContainer>
                            <s.ModalTitleLabel>제목:</s.ModalTitleLabel>
                            <Input
                                type="text"
                                value={title}
                                onChange={(e) => setTitle(e.target.value)}
                                isTitle={true}
                            />
                        </s.FlexContainer>
                        <br />
                        <s.FlexContainer>
                            <s.ModalContentLabel> 태그:</s.ModalContentLabel>
                            <Input
                                type="text"
                                value={tags}
                                onChange={(e) => setTags(e.target.value)}
                                isTitle={false}
                            />
                        </s.FlexContainer>
                        <br />
                        <s.FlexContainer>
                            <s.ModalContentLabel>시작일:</s.ModalContentLabel>
                            <Input
                                type="text"
                                value={startDate}
                                onChange={(e) => setStartDate(e.target.value)}
                                isTitle={false}
                            />
                        </s.FlexContainer>
                        <br />
                        <s.FlexContainer>
                            <s.ModalContentLabel>마감일:</s.ModalContentLabel>
                            <Input
                                type="text"
                                value={endDate}
                                onChange={(e) => setEndDate(e.target.value)}
                                isTitle={false}
                            />
                        </s.FlexContainer>
                        <br />
                        <s.CheckButton type="submit">Add</s.CheckButton>
                        <s.CancelButton onClick={() => setModalIsOpen(false)}>Cancel</s.CancelButton>
                    </form>
                </s.AddBtnContainer>
            </s.AddBtnModal>
        </>
    );
};

export default AddBtn;
