package com.example.backend.controller;

import com.example.backend.entity.SubjectEntity;
import com.example.backend.entity.TeamEntity;
import com.example.backend.service.TeamService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

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

    // 팀 생성
    @PostMapping("/create")
    public TeamEntity createTeam(@RequestBody SubjectEntity subject) {
        return teamService.createTeam(subject);
    }

    // 팀원 추가(이렇게 쓰고 싶지 않다...
    @PostMapping("/addUser")
    public ResponseEntity<String> addUserToTeam(@RequestParam Long userId, @RequestParam Long teamId, @RequestParam Long subjectId) {
        try {
            teamService.addUserToTeam(userId, teamId, subjectId);
            return ResponseEntity.ok("팀원 추가 성공");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
