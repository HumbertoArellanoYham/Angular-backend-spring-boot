package com.arellano.application.rest.springboot.springbootrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arellano.application.rest.springboot.springbootrest.entities.Sell;
import com.arellano.application.rest.springboot.springbootrest.repositories.SellRepository;

@Service
@Qualifier("sellService")
public class SellServiceImpl implements SellService{

    private SellRepository sellRepository;

    public SellServiceImpl(@Qualifier("sellRepository") SellRepository sellRepository) {
        this.sellRepository = sellRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Sell> listAll() {
        return (List<Sell>) sellRepository.findAll(); 
    }

    @Transactional
    @Override
    public Sell guardarVenta(Sell sell) {
        return sellRepository.save(sell);
    }
    
    @Transactional
    @Override
    public Optional<Sell> delete(Sell sell) {
        Optional<Sell> sellFindById = sellRepository.findById(sell.getIdVentas());

        sellFindById.ifPresent((s) -> {
            sellRepository.delete(s);
        });

        return sellFindById;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Sell> obtenerVentaPorFecha(String fecha) {
        Optional<Sell> getVentaOptional = sellRepository.obtenerVentaPorFecha(fecha);
        return getVentaOptional;
    }

    @Transactional
    @Override
    public void modificarStock(String nombre, Integer cantidad){
        sellRepository.modificarStock(nombre, cantidad);
    }

    @Override
    public Optional<Sell> findById(Long id) {
        return sellRepository.findById(id);
    }
}
