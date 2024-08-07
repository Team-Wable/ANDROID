package com.teamwable.data.repositoryimpl

import com.teamwable.data.mapper.toModel.toDummy
import com.teamwable.network.datasource.DummyService
import com.teamwable.data.repository.DummyRepository
import com.teamwable.model.Dummy
import javax.inject.Inject

internal class DefaultDummyRepository
@Inject
constructor(
    private val dummyService: DummyService,
) : DummyRepository {
    override suspend fun getDummy(): Result<List<Dummy>> {
        return runCatching {
            dummyService.getDummy().data?.map { it.toDummy() } ?: emptyList()
        }
    }
}
