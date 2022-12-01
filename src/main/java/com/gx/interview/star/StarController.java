package com.gx.interview.star;

import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("star")
public class StarController {

    private StarService starService;

    @PostMapping("/are-stars-unique")
    public Boolean areNamesUnique(@RequestBody List<Star> stars){
        return starService.areNamesUnique(stars);
    }

    @GetMapping("/closest")
    public List<Star> findClosestStars(@RequestBody List<Star> stars, int size){
        return starService.findClosestStars(stars, size);
    }

    @GetMapping("/filter")
    public List<Star> areNamesUnique(@RequestBody List<Star> stars, String regExpr){
        return starService.filterByRegExpr(stars, regExpr);
    }
}