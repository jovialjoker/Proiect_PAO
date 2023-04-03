package Controller;

import Service.SplitService;

import java.util.List;

public class SplitController {
    private SplitService _service;

    public SplitController(){
        _service = new SplitService();
    }

}
