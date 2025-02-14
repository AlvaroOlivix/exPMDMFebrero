package com.you.expmdmfebrero.domain.seta

class GetSetasUseCase(private val setasRepository: SetasRepository) {
    operator fun invoke(): List<Setas> {
        return setasRepository.getSetas()
    }
}