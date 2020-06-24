
package acme.features.administrator.dashboard;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select sector, count(a) from TechnologyRecord a group by a.sector")
	Collection<Object[]> totalNumberOftTechnologiesGroupedByActivitySector();

	@Query("select sector, count(a) from ToolRecord a group by a.sector")
	Collection<Object[]> totalNumberOfToolsGroupedByActivitySector();

	@Query("select indication, count(a) from TechnologyRecord a group by a.indication")
	Collection<Object[]> ratioOfOpenSourceTechnologies();

	@Query("select indication, count(a) from ToolRecord a group by a.indication")
	Collection<Object[]> ratioOfOpenSourceToolsVersusClosedSourceTools();

	@Query("select count(a) from ToolRecord a")
	Double totalTools();

	@Query("select count(a) from TechnologyRecord a")
	Double totalTechnologies();

}
