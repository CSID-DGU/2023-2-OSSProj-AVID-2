import { useState } from "react";
import "./App.css";
import MainPage from "./pages/MainPage/MainPage";
import { Route, Routes } from "react-router-dom";
import { Layout } from "./components/Layout/Layout";

import LoginPage from "./pages/LoginPage/LoginPage";
import SignupPage from "./pages/SignUpPage/SignUpPage";
import MyPage from "./pages/MyPage/MyPage";
import TeamPage from "./pages/TeamPage/TeamPage";

function App() {
  const [count, setCount] = useState(0);

  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<MainPage />}></Route>
      </Route>

      <Route path="/login" element={<LoginPage />}></Route>
      <Route path="/signup" element={<SignupPage />}></Route>

      <Route path="/mypage" element={<Layout />}>
        <Route index element={<MyPage />}></Route>
      </Route>
      <Route path="/teampage" element={<Layout />}>
        <Route index element={<TeamPage />}></Route>
      </Route>
    </Routes>
  );
}

export default App;
