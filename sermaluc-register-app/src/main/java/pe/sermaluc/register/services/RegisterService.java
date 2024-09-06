package pe.sermaluc.register.services;


import pe.sermaluc.register.contract.request.RequestUserRegister;
import pe.sermaluc.register.contract.response.ResponseUserRegister;


public interface RegisterService{
    ResponseUserRegister postUserRegister(RequestUserRegister requestUserRegister) throws Exception;
}
