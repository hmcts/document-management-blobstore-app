import java.nio.file.Path

import io.gatling.commons.util.PathHelper._

object Helper {

	val gatlingConfUrl: Path = getClass.getClassLoader.getResource("gatling.conf").getPath
	val projectRootDir = gatlingConfUrl.ancestor(3)

	val mavenSourcesDirectory = projectRootDir / "src" / "test" / "scala"
	val mavenResourcesDirectory = projectRootDir / "src" / "test" / "resources"
	val mavenTargetDirectory = projectRootDir / "target"
	val mavenBinariesDirectory = mavenTargetDirectory / "test-classes"

	val dataDirectory = mavenResourcesDirectory / "data"
	val bodiesDirectory = mavenResourcesDirectory / "bodies"

	val recorderOutputDirectory = mavenSourcesDirectory
	val resultsDirectory = mavenTargetDirectory / "results"

	val recorderConfigFile = mavenResourcesDirectory / "recorder.conf"
}