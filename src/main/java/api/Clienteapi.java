package api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ClienteService;

@Slf4j
@RestController
@RequestMapping("/v1/api/cliente")
public class Clienteapi {

    @Autowired
    private ClienteService clienteService;

}


