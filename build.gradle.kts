import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
	kotlin("multiplatform") version "2.0.20"
	`maven-publish`
}

group = "ru.landgrafhomyak"
version = "2.0"

repositories {
	mavenCentral()
}

@OptIn(ExperimentalWasmDsl::class)
kotlin {
	jvmToolchain(8)
	jvm {
	}
	js(IR) {
		browser()
		nodejs()
	}
	wasmWasi {
		nodejs()
	}
	wasmJs {
		nodejs()
		browser()
		d8()
	}

	macosArm64()
	macosX64()
	linuxArm64()
	linuxX64()
	mingwX64()
	androidNativeArm32()
	androidNativeArm64()
	androidNativeX64()
	androidNativeX86()
	iosArm64()
	iosSimulatorArm64()
	iosX64()
	tvosX64()
	tvosArm64()
	tvosSimulatorArm64()
	watchosX64()
	watchosArm32()
	watchosArm64()
	watchosDeviceArm64()
	watchosSimulatorArm64()

	sourceSets {
		val commonMain by getting
	}
}










