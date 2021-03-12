package br.com.mcos

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {

    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri Matheus")
        .setCpf("000.000.000-00")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.QA)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua das Tabajaras")
            .setCep("00000-000")
            .setComplemento("Casa 20")
            .build())
        .build()

    println("########## Request ############")

    print(request)

    println("###############################\n")

//    Grava o request em um arquivo
    request.writeTo(FileOutputStream("funcionario-request.bin"))

//    Lemos o objeto do arquivo
    val request2 = FuncionarioRequest.newBuilder().mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENTE)

    println("########## Saída dos dados do arquivo ############")

    print(request2)

    println("##################################################")
}