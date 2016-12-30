package com.forlv.webmagic.repository;

import com.forlv.webmagic.model.Shimengren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xiaoming on 2016/12/26.
 */

@Repository
public interface ShimengrenRepository extends JpaRepository<Shimengren, Integer> {

}
