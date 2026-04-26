package com.unimayor.TiendaVirtual.Natural_Samada.Service;

import org.springframework.stereotype.Service;
import com.unimayor.TiendaVirtual.Natural_Samada.Repository.ConfigRepository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Config;

import java.util.List;

@Service
public class ConfigService {

    private final ConfigRepository repository;

    public ConfigService(ConfigRepository repository) {
        this.repository = repository;
    }

    public List<Config> listar() {
        return repository.findAll();
    }

    public Config obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Config guardar(Config config) {
        return repository.save(config);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

