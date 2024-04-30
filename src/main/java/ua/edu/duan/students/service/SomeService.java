package ua.edu.duan.students.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomeService {

    private final ResourceBundleMessageSource resourceBundleMessageSource;
    public String hello(){
        return resourceBundleMessageSource.getMessage("welcome", ArrayUtils.toArray("User1"), LocaleContextHolder.getLocale());
    }
}
