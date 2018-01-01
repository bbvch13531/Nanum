package com.landvibe.nanum.restcontroller;

import com.landvibe.nanum.model.Board;
import com.landvibe.nanum.model.Study;
import com.landvibe.nanum.service.BoardService;
import com.landvibe.nanum.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studies")
public class StudyRestController {

    private StudyService studyService;
    private BoardService boardService;

    @Autowired
    public StudyRestController(StudyService studyService,BoardService boardService) {
        this.studyService = studyService;
        this.boardService = boardService;
    }

    @GetMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Study> studies() {
        return studyService.getAll();
    }

    @GetMapping("/{studyId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Study study(@PathVariable long studyId) {
        return studyService.getById(studyId);
    }

    @GetMapping("/{studyId}/boards")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Board> board(@PathVariable long studyId) {
        return boardService.getByStudy(studyId);
    }

}
