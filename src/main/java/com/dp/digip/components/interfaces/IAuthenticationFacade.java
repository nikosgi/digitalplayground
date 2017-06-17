package com.dp.digip.components.interfaces;

import org.springframework.security.core.Authentication;


public interface IAuthenticationFacade {
    Authentication getAuthentication();
}

