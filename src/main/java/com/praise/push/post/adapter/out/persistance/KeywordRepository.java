package com.praise.push.post.adapter.out.persistance;

import com.praise.push.post.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

interface KeywordRepository extends JpaRepository<Keyword, Long> {
}
