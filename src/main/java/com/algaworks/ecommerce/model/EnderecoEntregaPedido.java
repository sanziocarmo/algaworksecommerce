package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class EnderecoEntregaPedido {

    private String cep; // varchar(9)

    private String logradouro; // varchar(100)

    private String numero; // varchar(10)

    private String complemento; // varchar(50)

    private String bairro; // varchar(50)

    private String cidade; // varchar(50)

    private String estado; // varchar(2)
}
