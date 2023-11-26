package com.example.backend.controller;

import com.example.backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
}
