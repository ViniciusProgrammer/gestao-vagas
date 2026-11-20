package br.ufrn.imd.gestao_vagas.modules.candidate.controllers;

import br.ufrn.imd.gestao_vagas.modules.candidate.dto.AuthCandicateRequestDTO;
import br.ufrn.imd.gestao_vagas.modules.candidate.usecases.AuthCandidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class AuthCandidateController {

    @Autowired
    private AuthCandidateUseCase authCandidateUseCase;

    @PostMapping("/auth")
    public ResponseEntity<Object> auth(@RequestBody AuthCandicateRequestDTO authCandicateRequestDTO) {
        try {
            var token = this.authCandidateUseCase.excute(authCandicateRequestDTO);

            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
