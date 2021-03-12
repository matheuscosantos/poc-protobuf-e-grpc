package br.com.mcos

import io.grpc.ManagedChannelBuilder

fun main(){

//    Informações da conexão com o servidor
    val chanel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri Matheus")
        .setCpf("000.000.000-00")
        .setIdade(31)
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.QA)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua das Tabajaras")
            .setCep("00000-000")
            .setComplemento("Casa 20")
            .build())
        .build()

//    Instanciando o client para usarmos os métodos do Service
    val client = FuncionarioServiceGrpc.newBlockingStub(chanel)

    val response = client.cadastrar(request)

    println(response)

}
