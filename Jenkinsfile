#!groovy
@Library("Reform")
import uk.gov.hmcts.Ansible
import uk.gov.hmcts.Packager
import uk.gov.hmcts.RPMTagger

def rtMaven = Artifactory.newMavenBuild()

properties([
        [$class: 'GithubProjectProperty', displayName: 'CCD UserProfile performance tests', projectUrlStr: 'https://git.reform.hmcts.net/case-management/PerformanceTestsUserProfile.git']
])

lock('CCD API performance tests') {
    node {
        try {
            stage('Run performance tests') {
                deleteDir()
                checkout scm
                rtMaven.tool = 'apache-maven-3.3.9'
                rtMaven.run pom: 'pom.xml', goals: 'clean gatling:test -Dgatling.simulationClass=uk.gov.hmcts.ccd.simulation.UserProfileSimulation'

		report_dir = "target/gatling"

		sh "mkdir -p $report_dir/gendir"
		sh "mv $report_dir/userprofile*/* $report_dir/gendir/"

                publishHTML([
                        allowMissing         : false,
                        alwaysLinkToLastBuild: false,
                        keepAll              : true,
                        reportDir            : "target/gatling/gendir/",
                        reportFiles          : 'index.html',
                        reportName           : 'Performance Test Report'
                ])
            }

        } catch (err) {
            notifyBuildFailure channel: '#ccd_dev'
            throw err
        }
    }
}