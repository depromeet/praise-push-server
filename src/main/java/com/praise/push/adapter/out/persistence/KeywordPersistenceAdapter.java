package com.praise.push.adapter.out.persistence;

import com.praise.push.application.port.out.LoadKeywordPort;
import com.praise.push.domain.Keyword;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class KeywordPersistenceAdapter implements LoadKeywordPort {

    private final KeywordRepository keywordRepository;
    private final KeywordMapper keywordMapper;

    @Override
    public List<Keyword> loadKeywords() {
        return keywordRepository.findAll()
                .stream().map(keywordMapper::mapToModel).collect(Collectors.toList());
    }
}
