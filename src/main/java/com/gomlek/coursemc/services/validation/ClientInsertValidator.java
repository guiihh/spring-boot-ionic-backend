package com.gomlek.coursemc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.gomlek.coursemc.dto.ClientNewDTO;
import com.gomlek.coursemc.entities.Client;
import com.gomlek.coursemc.entities.enums.ClientType;
import com.gomlek.coursemc.repositories.ClientRepository;
import com.gomlek.coursemc.resources.exceptions.FieldMessage;
import com.gomlek.coursemc.services.validation.utils.BR;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO> {
    
    @Autowired
    private ClientRepository repo;

    @Override
    public void initialize(ClientInsert ann) {
    }
   
    @Override
    public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        if(objDto.getType().equals(ClientType.PESSOAFISICA.getCode()) && !BR.isValidCPF(objDto.getCpfOuCpnj())){
            list.add(new FieldMessage("cpfOuCpnj", "CPF INvalido"));
        }
        if(objDto.getType().equals(ClientType.PESSOAJURIDICA.getCode()) && !BR.isValidCPNJ(objDto.getCpfOuCpnj())){
            list.add(new FieldMessage("cpfOuCpnj", "CNPJ INvalido"));
        }

        Client aux = repo.findByEmail(objDto.getEmail());
        if(aux != null){
            list.add(new FieldMessage("email", "email já existe"));
        }

        // inclua os testes aqui, inserindo erros na lista
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
