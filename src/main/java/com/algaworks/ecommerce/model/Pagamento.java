package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
//@DiscriminatorColumn(name = "dtype",
@DiscriminatorColumn(name = "tipo_pagamento",
        discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table (name = "pagamento")
public abstract class Pagamento extends EntidadeBaseInteger {

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status; // varchar (30) not null
}

//package com.algaworks.ecommerce.model;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//
//import javax.persistence.*;
//
//@Getter
//@Setter
////@DiscriminatorColumn(name = "dtype") // Anterior
////@DiscriminatorColumn(name = "tipo_pagamento")
////@DiscriminatorColumn(name = "pagamentoCartao" ,
//        discriminatorType = DiscriminatorType.STRING)
//
////@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Significa TABELA ÚNICA...exemplo anterior
//@Inheritance(strategy = InheritanceType.JOINED)
//@Entity
//@Table(name = "pagamento")
//public abstract class Pagamento extends EntidadeBaseInteger {
//
//    @MapsId
//    @OneToOne(optional = false)
//    @JoinColumn(name = "pedido_id")
//    private Pedido pedido;
//
//    @Enumerated(EnumType.STRING)
//    private StatusPagamento status;
//
//
//
//@DiscriminatorColumn(name = "tipo_pagamento",
//}