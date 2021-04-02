package com.tournament.controller;

import com.tournament.persistence.MatchService;
import com.tournament.model.Matches;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {

    MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/saveMatch")
    public void addMatch(@ModelAttribute("Matches") Matches match) {
        matchService.saveMatch(match);
    }

    @GetMapping("/getAllMatch")
    public List<Matches> getAllMatch() {
        return matchService.getAllMatch();
    }

    @PutMapping("/updateMatch/{id}")
    public void updateMatch(@ModelAttribute("Matches") Matches match, @PathVariable("id") int id) {
        matchService.updateMatch(match, id);
    }

    @DeleteMapping("deleteMatch/{id}")
    public void deleteMatch(@PathVariable("id") int id) {
        matchService.deleteMatch(id);
    }

}
