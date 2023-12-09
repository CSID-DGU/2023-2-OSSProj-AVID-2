package com.example.backend.controller;

import com.example.backend.controller.request.AddUserToTeamRequestDTO;
import com.example.backend.controller.request.CreateTeamRequestDTO;
import com.example.backend.controller.response.Response;
import com.example.backend.controller.response.UserLoginResponseDTO;
import com.example.backend.controller.response.UserTeamResponseDTO;
import com.example.backend.entity.TeamEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private UserRepository userRepository;

    // 각 과목 수강 학생
    @GetMapping("/userNames/{subjectId}")
    public List<String> getUserNamesBySubjectId(@PathVariable Long subjectId) {
        return teamService.getUserNamesBySubjectId(subjectId);
    }

    // 유저의 팀 정보
    @GetMapping("/subjectName/{userId}")
    public String getSubjectNameByUserId(@PathVariable Long userId) {
        return teamService.getSubjectNameByUserId(userId);
    }

    // 각 팀의 팀원 정보
    @GetMapping("/userInfo/{teamId}")
    public List<String> getUserInfoByTeamId(@PathVariable Long teamId) {
        return teamService.getUserInfoByTeamId(teamId);
    }

    // 팀 생성 화면
    // 유저가 수강하는 과목
    @GetMapping("/create/{userId}")
    public List<String> getSubjectByUserId(@PathVariable Long userId) {
        return teamService.getSubjectByUserId(userId);
    }

//    // 팀 생성
//    @PostMapping("/create")
//    public TeamEntity createTeam(@RequestBody SubjectEntity subject) {
//        return teamService.createTeam(subject);
//    }

    // 팀 생성 보완(유저 추가)
    @PostMapping("/create")
    public Response<TeamEntity> createTeam(@RequestBody CreateTeamRequestDTO requestDTO, HttpSession session) {
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");

        UserEntity user = userRepository
                .findByUserID(loginUser.getUserID())
                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다. ID: " + loginUser.getUserID()));

        return Response.success(teamService.createTeamAndAddUser(requestDTO, user));

    }

    // 팀원 추가(이렇게 쓰고 싶지 않다...
//    @PostMapping("/addUser")
//    public ResponseEntity<String> addUserToTeam(@RequestParam Long userId, @RequestParam Long teamId, @RequestParam Long subjectId) {
//        try {
//            teamService.addUserToTeam(userId, teamId, subjectId);
//            return ResponseEntity.ok("팀원 추가 성공");
//        } catch (NotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//    }

    // 팀원 추가 (보완)
    @PostMapping("/{teamId}/addUser")
    public Response<Void> addUserToTeamV1(@PathVariable Long teamId, @RequestBody AddUserToTeamRequestDTO requestDTO) {
        teamService.addUserToTeamV1(requestDTO, teamId);
        return Response.success();
    }

    // 본인 팀 리스트
    @GetMapping("/list")
    public Response<List<UserTeamResponseDTO>> getTeamList(HttpSession session) {
        UserLoginResponseDTO loginUser = (UserLoginResponseDTO) session.getAttribute("loginUser");

        return Response.success(teamService.getTeamList(loginUser));
    }

}
