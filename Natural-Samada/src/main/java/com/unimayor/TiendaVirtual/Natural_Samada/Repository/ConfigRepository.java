package com.unimayor.TiendaVirtual.Natural_Samada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Config;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {
}

